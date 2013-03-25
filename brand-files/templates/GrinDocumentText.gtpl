{namespace Page.Document}

{template .MiddleSection.OverviewMain}
	{meta override=true}

	{* Abstract is very duplicate content because it is distributed to 
	all retailers. Only display abstract if no preview is available *}
	{if _.text.render_mode == 'none'}
		{call .MiddleSection.Abstract}
	{else}
		{call .MiddleSection.Text}
	{/if}
{/template}
