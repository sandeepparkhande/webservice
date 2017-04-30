package com.sandeep.web.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
public class Error {
	 
		private String errorCode;
		private String  errorStatus;
		private String description;
	
		public Error() {
		}
		public Error(String errorCode, String errorStatus, String description) {
			super();
			this.errorCode = errorCode;
			this.errorStatus = errorStatus;
			this.description = description;
		}
		public String getErrorCode() {
			return errorCode;
		}
		
		@XmlElement
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorStatus() {
			return errorStatus;
		}
		
		@XmlElement
		public void setErrorStatus(String errorStatus) {
			this.errorStatus = errorStatus;
		}
		public String getDescription() {
			return description;
		}
		
		@XmlElement
		public void setDescription(String description) {
			this.description = description;
		}
		

}
