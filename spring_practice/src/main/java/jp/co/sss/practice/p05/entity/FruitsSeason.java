package jp.co.sss.practice.p05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "fruits_season")
public class FruitsSeason {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fruits_season")
    @SequenceGenerator(name = "seq_fruits_season", sequenceName = "seq_fruits_season", allocationSize = 1)
	
    @Column(name = "fruit_id")
	private Integer fruitId;
	@Column(name = "fruit_name")
    private String fruitName;
    @Column(name = "season_month")
    private Integer seasonMonth;


	public Integer getSeasonMonth() {
		return seasonMonth;
	}

	public void setSeasonMonth(Integer seasonMonth) {
		this.seasonMonth = seasonMonth;
	}

	public Integer getFruitId() {
		return fruitId;
	}

	public void setFruitId(Integer fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}



}
