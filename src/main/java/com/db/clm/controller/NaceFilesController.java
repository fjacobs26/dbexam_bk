package com.db.clm.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.db.clm.model.Nace;
import com.db.clm.service.NaceServices;

@Controller
@RequestMapping("/gft")
public class NaceFilesController {

	@Autowired
	private NaceServices naceServices;

	@PostMapping("/add/registry")
	public ResponseEntity<Nace> postNaceValue(@RequestBody Nace nace) {
        Nace response = naceServices.addNace(nace);
        if (response==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nace, HttpStatus.OK);
	}
	
	@PostMapping("/upload/csv")
	public ResponseEntity<String> postNaceDetails(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			try {
				byte[] bytes = file.getBytes();
				ByteArrayInputStream inputFilestream = new ByteArrayInputStream(bytes);
				BufferedReader br = new BufferedReader(new InputStreamReader(inputFilestream));
				List<String> csvArray = br.lines().skip(1).filter(naceFilter -> naceFilter.split(",").length > 1)
						.filter(naceFilter -> naceFilter.split(",").length == 10).map(naceRow -> {
							return naceRow.replace("\"", "").replace("\n", "").replace("\r", "");
						}).collect(Collectors.toList());
				boolean isSaved = naceServices.storeCsv(csvArray);
				br.close();
				if (isSaved) {
					return new ResponseEntity<>("Document Saved in the DB", HttpStatus.ACCEPTED);
				} else {
					return new ResponseEntity<>("Insertations fails", HttpStatus.INTERNAL_SERVER_ERROR);
				}

			} catch (IOException e) {
				return new ResponseEntity<>("Document not allowed", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	@DeleteMapping(value = "/delete/{id}")
	 public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        boolean isRemoved = naceServices.deleteNace(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
	//For frontend test
	@GetMapping("/nace/list")
	public ResponseEntity<List<Nace>> getAllRegistries() {
        return new ResponseEntity<>(naceServices.getAll(), HttpStatus.OK);
    }

}
