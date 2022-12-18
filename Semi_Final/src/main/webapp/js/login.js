/**
 * 
 */
let frm_login = document.frm_login;

function login(){
	frm_login.action = "login.do?job=login";
	frm_login.submit();	
}