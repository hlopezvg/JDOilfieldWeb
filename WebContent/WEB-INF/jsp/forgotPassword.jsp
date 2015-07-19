<form method="post" action="">
	<fieldset class="fieldsetInterno">
		<legend>Password Recovery</legend>
		<table width="75%" border="0" cellpadding="0" cellspacing="0">
			<tr align="left">
				<td rowspan="2"><img src="images/keys_64x64.gif" alt="" />
				</td>
				<td>email:</td>
				<td>
				<spring:bind path="forgotPassword.mail">
						<input type="text" name="mail" />
				</spring:bind></td>
			</tr>
		</table>
		<table width="258" border="0" align="center">
              <tr>
                <td width="82" align="center"> 
    	            <input type="submit" name="send_credentials" value="Reset Password" />
                </td>
              </tr>
        </table>
	</fieldset>
</form>