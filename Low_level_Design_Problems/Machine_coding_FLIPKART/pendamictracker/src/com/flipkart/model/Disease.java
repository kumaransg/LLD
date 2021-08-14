package com.flipkart.model;

import java.util.Date;

public class Disease {
		private String DiseaseName;
		private Date InfectionDate;
		private String Status;

		public Date getInfectionDate() {
			return InfectionDate;
		}

		public void setInfectionDate(Date infectionDate) {
			InfectionDate = infectionDate;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

		public String getDiseaseName() {
			return DiseaseName;
		}

		public Disease(String diseaseName, Date infectionDate) {
			DiseaseName = diseaseName;
			InfectionDate = infectionDate;
		}

		public void setDiseaseName(String diseaseName) {
			DiseaseName = diseaseName;
		}

}
