	<?php
		$con = mysqli_connect("107.170.18.96:3306", "ebay", "ebay3344", "ebayForcaster");
		if (mysqli_connect_errno()) {
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		
		$result = mysqli_query($con,"SELECT DISTINCT productId FROM Item");

		function getProductNameOutput($id) {			
				$strTemp = "";			
			
			
			switch ($id) {
				case "175299667":				
					$strTemp .= "XBox";
					break;
				case "167317351":
					$strTemp .= "Sony Playstation";
					break;
				case "168508202":
					$strTemp .= "iPhone 5S";
					break;
				case "102587397":
					$strTemp .= "XBox (2)";
					break;											
				case "175256176":
					$strTemp .= "Google Nexus 5";
					break;					
					  
				default:
					$strTemp = "";		
					break;
			}					
			
			return $strTemp;

		}
		
		function getProductName($id) {			
			$strTemp = '<option value='.$id.'>';			
			
			
			switch ($id) {
				case "175299667":				
					$strTemp .= "XBox</option>";
					break;
				case "167317351":
					$strTemp .= "Sony Playstation</option>";
					break;
				case "168508202":
					$strTemp .= "iPhone 5S</option>";
					break;
				case "102587397":
					$strTemp .= "XBox (2)</option>";
					break;											
				case "175256176":
					$strTemp .= "Google Nexus 5</option>";
					break;					
					  
				default:
					$strTemp = "";		
					break;
			}					
			
			return $strTemp;

		}
	?>