<?php
		//array containing data. Format should be:
		//item 0 - mean price.
		//item 1 - number of attributes.
		//items 2 to n + 1 attributes.
		//items n + 2 to 2n + 1 linear regression coefficients.
		//skip 2n + 2
		//item 2n + 3 LR constant
		//item 2n + 4 to 3n + 3 SVM weights
		//item 3n + 4 SVM constant
		
		$productId = $_POST["productId"];
		
		exec("java -jar jar/ebaySelect.jar ".$productId." 2>&1", $outputArr, $err);
		
		//var_dump($outputArr);
		
		$errOffset = 4; //number of lines to disregard
		//Regression constant and anything beyond that should skip one
				
		
		$meanPrice = $outputArr[0 + $errOffset]; //mean price
		$n = $outputArr[1 + $errOffset]; //n number of attributes
		$LRCONST = $outputArr[2 * $n + 2 + $errOffset + 1]; //skip one
		$SVMCONST = $outputArr[3 * $n + 3 + $errOffset + 1]; //skip one
		
		//attributes, coefficients and weights arrays
		for($i = 0; $i < $n; $i++) {
			$attributes[$i] = $outputArr[$i + 2 + $errOffset]; //not skipping one
			$coefficients[$i] = $outputArr[$i + $n + 2 + $errOffset]; //not skipping one
			$weights[$i] = $outputArr[$i + 2 * $n + 3 + $errOffset + 1]; //skipping one
		}
		

		function checkActive($strData) {
			$classType = "";
			if(floatval($strData) > 0) {
				$classType = "success";			
			}
			else if(floatval($strData) < 0 ) {
				$classType = "danger";
			}
			else {
				$classType = "active";
			}
			
			return $classType;
		}
		
		function buildRows() {			
			global $meanPrice, $n, $LRCONST, $SVMCONST, $attributes, $coefficients, $weights;
		
			for($i = 0; $i < $n; $i++) {						
				echo "<tr>";
					echo "<td>";
					echo $attributes[$i];
					echo "</td>";
					echo "<td class=".checkActive($coefficients[$i]).">";
					echo $coefficients[$i];
					echo "</td>";
					echo "<td class=".checkActive($weights[$i]).">";
					echo $weights[$i];
					echo "</td>";
				echo "</tr>";
			}
		}
		
		
	?>	