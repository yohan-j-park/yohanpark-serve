/**
 * 
 */
var frm = document.frm_sales;
function auto_input(){         
        if(frm.status.value == "재고등록"){
           if(frm.pr_code.value.includes("brain")){
              frm.pr_cost.value = frm.x02.value;
              frm.real_price.value = Number(frm.x02.value)*(1+Number(frm.x03.value));
              frm.vat.value = (Number(frm.x02.value)*(1+Number(frm.x03.value)))*0.1;
              frm.supply_price.value = (Number(frm.x02.value)*(1+Number(frm.x03.value))*1.1).toFixed(0);
           }
         if(frm.pr_code.value.includes("neuron")){
            frm.pr_cost.value = frm.x12.value;
              frm.real_price.value = Number(frm.x12.value)*(1+Number(frm.x13.value));
              frm.vat.value = (Number(frm.x12.value)*(1+Number(frm.x13.value)))*0.1;
              frm.supply_price.value = (Number(frm.x12.value)*(1+Number(frm.x13.value))*1.1).toFixed(0);      
           }
         if(frm.pr_code.value.includes("arm")){
            frm.pr_cost.value = frm.x22.value;
              frm.real_price.value = Number(frm.x22.value)*(1+Number(frm.x23.value));
              frm.vat.value = (Number(frm.x22.value)*(1+Number(frm.x23.value)))*0.1;
              frm.supply_price.value = (Number(frm.x22.value)*(1+Number(frm.x23.value))*1.1).toFixed(0);
         }
         if(frm.pr_code.value.includes("leg")){
            frm.pr_cost.value = frm.x32.value;
              frm.real_price.value = Number(frm.x32.value)*(1+Number(frm.x33.value));
              frm.vat.value = (Number(frm.x32.value)*(1+Number(frm.x33.value)))*0.1;
              frm.supply_price.value = (Number(frm.x32.value)*(1+Number(frm.x33.value))*1.1).toFixed(0);
         }
         if(frm.pr_code.value.includes("body")){
            frm.pr_cost.value = frm.x42.value;
              frm.real_price.value = Number(frm.x42.value)*(1+Number(frm.x43.value));
              frm.vat.value = (Number(frm.x42.value)*(1+Number(frm.x43.value)))*0.1;
              frm.supply_price.value = (Number(frm.x42.value)*(1+Number(frm.x43.value))*1.1).toFixed(0);
         }
         if(frm.pr_code.value.includes("head")){
            frm.pr_cost.value = frm.x52.value;
              frm.real_price.value = Number(frm.x52.value)*(1+Number(frm.x53.value));
              frm.vat.value = (Number(frm.x52.value)*(1+Number(frm.x53.value)))*0.1;
              frm.supply_price.value = (Number(frm.x52.value)*(1+Number(frm.x53.value))*1.1).toFixed(0);
         }
        }
}