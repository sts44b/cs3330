/*
 * Name: Seanmichael Stanley
 * TA: matt English
 * section D
 * 3/17/14
 * labcode: Bioprocess
 */

package sts44b.cs3330.lab6;

public class Developer extends Employee{
	private String langOfProf;
	
	public Developer (String name, int SSN, String langOfProf){
		super(name, SSN);
		this.setLangProf(langOfProf);
	}
	
	protected void setLangProf(String LangOfProf){
		this.langOfProf = getLangProf();
	}
	
	public String getLangProf(){
		return this.langOfProf;
	}

}
