package com.db.clm.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.db.clm.model.Nace;
import com.db.clm.service.NaceServices;

import org.junit.Assert;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NaceDAOTest {
	@Autowired
	private NaceServices naceService;
	
	@Test
	@Transactional
    @Rollback(true)
	public void givenNaceListStored()
			  throws Exception{
		Nace nace = new Nace();
		nace.setOrder(1L);
		nace.setLevel(10000);
		nace.setCode("10000");
		nace.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		nace.setIsic_reference("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
		nace.setItem_description("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
		nace.setItem_exclude("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.");
		nace.setItem_extra("The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
		nace.setParent("Aenean aliquam, arcu a elementum malesuada, mi orci congue sem, eget dapibus diam turpis pulvinar felis. Suspendisse malesuada mauris massa, quis tristique erat vestibulum vel. Integer hendrerit purus eget convallis gravida. Aenean congue dolor vitae cursus congue. Sed urna risus, faucibus at libero quis, porta tempus mi. Pellentesque at lectus sed diam laoreet blandit. Vestibulum vulputate augue ut nisi egestas, sit amet malesuada nibh vehicula. Maecenas nec neque augue. Cras ac semper nulla. Ut scelerisque ipsum aliquam, congue ipsum eget, malesuada arcu. Nulla consectetur at arcu vel tincidunt. Donec pretium metus a lectus pretium, at pharetra tellus fermentum. Phasellus congue elit sed convallis mollis. Ut nisl eros, placerat at lectus sit amet, dictum convallis tortor.");
		nace.setRulings("Cras elit neque, interdum id diam in, vulputate fermentum nulla. Fusce efficitur tempus dui id vulputate. Suspendisse lacinia faucibus porttitor. Praesent non nibh viverra, consequat metus ac, efficitur orci. Aenean in vestibulum lectus. Nulla porttitor neque sit amet elementum efficitur. Sed tristique urna vel commodo mollis. Duis quis tempus purus, blandit lobortis velit. Praesent volutpat pharetra gravida. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean tempus, ligula ut porttitor blandit, mauris sem gravida lacus, vel ultricies dui neque ac urna. Nullam congue elit eget ex iaculis blandit. Suspendisse vitae nibh rhoncus, lobortis tortor sodales, tempor magna. Proin sed urna id nisi luctus ultrices. Ut magna ligula, tempor euismod dignissim a, euismod a lorem. Praesent nec scelerisque sapien.");
		naceService.addNace(nace);
        
        List<Nace> naceList = naceService.getAll();
                 
        Assert.assertEquals(1, naceList.size());
         
        Assert.assertEquals(nace.getCode(), naceList.get(0).getCode());
	}
	@Test
	public void getAllNaceRegistries()
			  throws Exception{
        List<Nace> naceList = naceService.getAll();
        
        if(!naceList.isEmpty()) assertThat(naceList).isNotNull();
	}
	
}
