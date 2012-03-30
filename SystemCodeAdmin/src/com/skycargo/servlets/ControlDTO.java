package com.skycargo.servlets;

import com.skycargo.util.GeneralUtil;

public class ControlDTO {
	private int controlId;
	private String controlName;
	private String controlDisplayName;
	private String controlType;
	private int controlSize;
	private String controlDataType;
	private String Value;
	private String tableColName;
	private boolean sysGeneratedCol;

	/**
	 * @return the controlId
	 */
	public int getControlId() {
		return controlId;
	}

	/**
	 * @param controlId the controlId to set
	 */
	public void setControlId(int controlId) {
		this.controlId = controlId;
	}

	/**
	 * @return the controlDisplayName
	 */
	public String getControlDisplayName() {
		return controlDisplayName;
	}

	/**
	 * @param controlDisplayName
	 *            the controlDisplayName to set
	 */
	public void setControlDisplayName(String controlDisplayName) {
		this.controlDisplayName = controlDisplayName;
	}

	/**
	 * @param controlName the controlName to set
	 */
	public String getControlName() {
		return controlName; 
	}

	/**
	 * @return the controlDataType
	 */
	public String getControlDataType() {
		return controlDataType;
	}

	/**
	 * @param controlDataType
	 *            the controlDataType to set
	 */
	public void setControlDataType(String controlDataType) {
		this.controlDataType = controlDataType;
	}

	/**
	 * @param controlName
	 *            the controlName to set
	 */
	public void setControlName(String controlName) {
		this.controlName=GeneralUtil.createJavaVarName(controlName);;
	}

	/**
	 * @return the controlType
	 */
	public String getControlType() {
		return controlType;
	}

	/**
	 * @param controlType
	 *            the controlType to set
	 */
	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	/**
	 * @return the controlSize
	 */
	public int getControlSize() {
		return controlSize;
	}

	/**
	 * @param controlSize
	 *            the controlSize to set
	 */
	public void setControlSize(int controlSize) {
		this.controlSize = controlSize;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return Value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		Value = value;
	}

	/**
	 * @return the tableColName
	 */
	public String getTableColName() {
		return tableColName;
	}

	/**
	 * @param tableColName the tableColName to set
	 */
	public void setTableColName(String tableColName) {
		this.tableColName = tableColName;
	}



	/**
	 * @return the sysGeneratedCol
	 */
	public boolean isSysGeneratedCol() {
		return sysGeneratedCol;
	}

	/**
	 * @param sysGeneratedCol the sysGeneratedCol to set
	 */
	public void setSysGeneratedCol(boolean sysGeneratedCol) {
		this.sysGeneratedCol = sysGeneratedCol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ControlDTO [Value=");
		builder.append(Value);
		builder.append(", controlDataType=");
		builder.append(controlDataType);
		builder.append(", controlDisplayName=");
		builder.append(controlDisplayName);
		builder.append(", controlId=");
		builder.append(controlId);
		builder.append(", controlName=");
		builder.append(controlName);
		builder.append(", controlSize=");
		builder.append(controlSize);
		builder.append(", controlType=");
		builder.append(controlType);
		builder.append(", tableColName=");
		builder.append(tableColName);
		builder.append(", sysGeneratedCol=");
		builder.append(sysGeneratedCol);
		builder.append("]");
		return builder.toString();
	}
}
