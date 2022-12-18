/**
 * 
 */

	
var frm = document.frm_input;
  	function auto_pr_info(){
  		if(frm.pr_code.value.includes("brain")) {
  			frm.pr_name.value = "엑스봇로봇두뇌";
  			frm.taken_time.value = "108";
  			frm.status.value = "재고등록";
  			frm.update_time.value = frm.date.value;
  			frm.pr_cost.value = frm.x02.value;
  			frm.real_price.value = Number(frm.x02.value)*(1+Number(frm.x03.value));
  			frm.vat.value = (Number(frm.x02.value)*(1+Number(frm.x03.value)))*0.1;
  			frm.supply_price.value = Number(frm.x02.value)*(1+Number(frm.x03.value))*1.1;
  		}
  		if(frm.pr_code.value.includes("neuron")) {
  			frm.pr_name.value = "엑스봇로봇신경";
  			frm.taken_time.value = "135";
  			frm.status.value = "재고등록";
  			frm.update_time.value = frm.date.value;
  			frm.pr_cost.value = frm.x12.value;
  			frm.real_price.value = Number(frm.x12.value)*(1+Number(frm.x13.value));
  			frm.vat.value = (Number(frm.x12.value)*(1+Number(frm.x13.value)))*0.1;
  			frm.supply_price.value = Number(frm.x12.value)*(1+Number(frm.x13.value))*1.1;
  		}
  		if(frm.pr_code.value.includes("arm")) {
  			frm.pr_name.value = "엑스봇로봇팔";
  			frm.taken_time.value = "60";
  			frm.status.value = "재고등록";
  			frm.update_time.value = frm.date.value;
  			frm.pr_cost.value = frm.x22.value;
  			frm.real_price.value = Number(frm.x22.value)*(1+Number(frm.x23.value));
  			frm.vat.value = (Number(frm.x22.value)*(1+Number(frm.x23.value)))*0.1;
  			frm.supply_price.value = Number(frm.x22.value)*(1+Number(frm.x23.value))*1.1;
  		}
  		if(frm.pr_code.value.includes("leg")) {
  			frm.pr_name.value = "엑스봇로봇다리";
  			frm.taken_time.value = "60";
  			frm.status.value = "재고등록";
  			frm.update_time.value = frm.date.value;
  			frm.pr_cost.value = frm.x32.value;
  			frm.real_price.value = Number(frm.x32.value)*(1+Number(frm.x33.value));
  			frm.vat.value = (Number(frm.x32.value)*(1+Number(frm.x33.value)))*0.1;
  			frm.supply_price.value = Number(frm.x32.value)*(1+Number(frm.x33.value))*1.1;
  		}
  		if(frm.pr_code.value.includes("body")) {
  			frm.pr_name.value = "엑스봇로봇몸통";
  			frm.taken_time.value = "100";
  			frm.status.value = "재고등록";
  			frm.update_time.value = frm.date.value;
  			frm.pr_cost.value = frm.x42.value;
  			frm.real_price.value = Number(frm.x42.value)*(1+Number(frm.x43.value));
  			frm.vat.value = (Number(frm.x42.value)*(1+Number(frm.x43.value)))*0.1;
  			frm.supply_price.value = Number(frm.x42.value)*(1+Number(frm.x43.value))*1.1;
  		}
  		if(frm.pr_code.value.includes("head")) {
  			frm.pr_name.value = "엑스봇로봇머리";
  			frm.taken_time.value = "60";
  			frm.status.value = "재고등록";
  			frm.update_time.value = frm.date.value;
  			frm.pr_cost.value = frm.x52.value;
  			frm.real_price.value = Number(frm.x52.value)*(1+Number(frm.x53.value));
  			frm.vat.value = (Number(frm.x52.value)*(1+Number(frm.x53.value)))*0.1;
  			frm.supply_price.value = Number(frm.x52.value)*(1+Number(frm.x53.value))*1.1;
  		}
  	}