package com.sandeep.web.bean;

public class Error {
	 
		private String errorCode;
		private String  errorStatus;
		private String description;
	
		public Error(String errorCode, String errorStatus, String description) {
			super();
			this.errorCode = errorCode;
			this.errorStatus = errorStatus;
			this.description = description;
		}
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorStatus() {
			return errorStatus;
		}
		public void setErrorStatus(String errorStatus) {
			this.errorStatus = errorStatus;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		

}
