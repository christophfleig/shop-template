{namespace Structure.LoginPopup}


{template .Box.RegisterAdditionalFields}
	{meta override=true}

	<div class="form-row ambassador">
		<label>{NLS('Page::Commons::AmbassadorToken')}</label>
		<input type="text" name="ambassador"/>
		<input type="hidden" name="amb-strict" value="yes"/>
	</div>

	<div class="form-row infomail">
			<div class="hint hint-icon">
			<div class="hint-target"></div>
			<div class="hint-text">
				{NLS('Page::Commons::InfoMailRegisterInfo')}
			</div>
		</div>

		<input type="checkbox" id="loginpopup-infomail" name="infomail" grin:datatype="YES_NO"/>
		<label for="loginpopup-infomail" class="info1">
				{NLS('Page::Commons::SubscribeInfoMail')}
		</label>
		<div class="info2">
				{NLS('Page::Commons::CancelInfoMailDisclaimer')}
		</div>
	</div>
{/template}

