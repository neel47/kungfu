//Date range filter
			var minDateFilter = "";
			var maxDateFilter = "";

			$(document).ready(function() {
				var oTable = $('#dataTable').dataTable({
			    	 "order": []

			    });
				 $("#datepicker_from").datepicker({ dateFormat: 'yy-mm-dd' }).change(function() {
				        minDateFilter = new Date(this.value).getTime();
				        oTable.fnDraw();
				      });

				      $("#datepicker_to").datepicker({ dateFormat: 'yy-mm-dd' }).change(function() {
				        maxDateFilter = new Date(this.value).getTime();
				        oTable.fnDraw();
				      });
			})
		
		
$.fn.dataTableExt.afnFiltering.push(
  function(oSettings, aData, iDataIndex) {
    if (typeof aData._date == 'undefined') {
      aData._date = new Date(aData[0]).getTime();
    }

    if (minDateFilter && !isNaN(minDateFilter)) {
      if (aData._date < minDateFilter) {
        return false;
      }
    }

    if (maxDateFilter && !isNaN(maxDateFilter)) {
      if (aData._date > maxDateFilter) {
        return false;
      }
    }

    return true;
  }
);
			
			