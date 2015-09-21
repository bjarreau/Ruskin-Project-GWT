package com.ruskin.project.client;

import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/** A slippy map widget designed for displaying the location of contacts.
 * 	There is one layer in this widget for displaying the
 * 	images representing contacts.  
 * <p>
 *  Other layers, including WMS layers, can be added to this widget as well.
 * </p>
 *
 */
public class PlaceMapWidget implements IsWidget {

	private final MainWidget master;	
	private final VerticalPanel decorator;
	private final MapOptions options;
	private final MapWidget mapWidget;
	
	public PlaceMapWidget(int width, int height, MainWidget master) {		
		this.master = master;
		options = new MapOptions ();
		options.setNumZoomLevels(30);
		mapWidget = new MapWidget(new Integer(width).toString(), new Integer(height).toString(), options);
		
		decorator = new VerticalPanel();
		decorator.setStyleName("mapDecorator");
		
		Label mapLbl = new Label("The Map Widget Will Go Here");
		mapLbl.setStyleName("flexTableCellHead");
		HorizontalPanel mapPlaceHolder = new HorizontalPanel();
		mapPlaceHolder.setStyleName("flexTableCell");
		mapPlaceHolder.add(mapWidget);	
		decorator.add(mapLbl);
		decorator.add(mapPlaceHolder);
		
		BuildUI();
	}	
	
	private void BuildUI() {
		final HorizontalPanel buttonPanel = new HorizontalPanel();
		final CheckBox Margaret = new CheckBox("Margaret");
		final CheckBox JohnJames = new CheckBox("John James");
		final CheckBox JohnPast = new CheckBox("John");
		final CheckBox JohnFuture = new CheckBox ("John's Plans");
			
		buttonPanel.getElement().getStyle().setProperty("height", "inherit");
	
		buttonPanel.add(Margaret);
		buttonPanel.add(JohnJames);			
		buttonPanel.add(JohnPast);
		buttonPanel.add(JohnFuture);
		
		decorator.add(buttonPanel);
	}

	@Override
	public Widget asWidget() {
		return decorator;
	}
}


