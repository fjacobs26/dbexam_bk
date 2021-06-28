package com.db.clm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Nace")
public class Nace {
	@Id
	@Column(name = "order_nace")
	private long order;
	
	@Column(name = "level_nace")
	private Integer level;
	@Lob 
	@Column(name = "code_nace", length=512)
	private String code;
	
	@Lob 
	@Column(name = "parent_nace", length=512)
	private String parent;
	
	@Lob 
	@Column(name = "description_nace", length=512)
	private String description;
	
	@Lob 
	@Column(name = "item_description_nace", length=512)
	private String item_description;
	
	@Lob 
	@Column(name = "item_extra_nace", length=512)
	private String item_extra;
	
	@Lob 
	@Column(name = "rulings_nace", length=512)
	private String rulings;
	
	@Lob 
	@Column(name = "item_exclude_nace", length=512)
	private String item_exclude;
	
	@Lob 
	@Column(name = "isic_reference_nace", length=512)
	private String isic_reference;
	
	public Nace() {
		
	}
	public Nace(long order, Integer level, String code, String parent, String description, String item_description,
			String item_extra, String rulings, String item_exclude, String isic_reference) {
		super();
		this.order = order;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.item_description = item_description;
		this.item_extra = item_extra;
		this.rulings = rulings;
		this.item_exclude = item_exclude;
		this.isic_reference = isic_reference;
	}

	public void setOrder(long order) {
		this.order = order;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public void setItem_extra(String item_extra) {
		this.item_extra = item_extra;
	}
	public void setRulings(String rulings) {
		this.rulings = rulings;
	}
	public void setItem_exclude(String item_exclude) {
		this.item_exclude = item_exclude;
	}
	public void setIsic_reference(String isic_reference) {
		this.isic_reference = isic_reference;
	}
	public long getOrder() {
		return order;
	}

	public Integer getLevel() {
		return level;
	}

	public String getCode() {
		return code;
	}

	public String getParent() {
		return parent;
	}

	public String getDescription() {
		return description;
	}

	public String getItem_description() {
		return item_description;
	}

	public String getItem_extra() {
		return item_extra;
	}

	public String getRulings() {
		return rulings;
	}

	public String getItem_exclude() {
		return item_exclude;
	}

	public String getIsic_reference() {
		return isic_reference;
	}

	
	
	
}
