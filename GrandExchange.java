import java.text.DecimalFormat;

import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Widget;
import org.powerbot.script.rt4.Widgets;

public class GrandExchange extends PollingScript<ClientContext>{
	public final Widget geWidget = ctx.widgets.widget(105);
	
	private enum Slot {
		SLOT_1(geWidget.component(28),geWidget.component(170),geWidget.component(174)),
		SLOT_2(geWidget.component(30),geWidget.component(178),geWidget.component(184)),
		SLOT_3(geWidget.component(33),geWidget.component(170),geWidget.component(175)),
		SLOT_4(geWidget.component(35),geWidget.component(170),geWidget.component(175)),
		SLOT_5(geWidget.component(38),geWidget.component(170),geWidget.component(175)),
		SLOT_6(geWidget.component(39),geWidget.component(170),geWidget.component(175));
		
		//(MAINSLOTCOMPONENT,BUYBUTTONCOMPONENT,SELLBUTTONCOMPONENT)
	}
	
	public double customFormat(double value ) {
	      DecimalFormat myFormatter = new DecimalFormat("###.##");
	      String output = myFormatter.format(value);
		return Double.parseDouble(output);
	   }

	public Component getSlot(int slot){
		Widget geWidget = ctx.widgets.widget(105);
		switch(slot){
		case 1:
			return geWidget.component(28);
		case 2:
			return geWidget.component(30);
		case 3:
			return geWidget.component(33);
		case 4:
			return geWidget.component(35);
		case 5:
			return geWidget.component(37);
		case 6:
			return geWidget.component(39);
		default:
			return geWidget.component(28); //Default is first slot
		}
	}
	
	public String getPrice(int slot){ // gets price you are buying or selling for at specified ge slot
		return getSlot(slot).component(10).text();
	}

	public String getName(int slot){ //gets name of item at specified ge slot
		return getSlot(slot).component(9).text();
	}
	
	public double getPercentSold(int slot){ // gets the current width of the bar on the main gewidget and devides it by total width
		int width = getSlot(slot).component(4).width();
		int percentSold = (width/133)*100;
		return customFormat(percentSold); //format is 3 digits with 2 decimal places.
	}
	public void buyItem(int id, int slot){//Buy item with specified id at specified slot
		
	}
	
	@Override
	public void poll() {
		// TODO Auto-generated method stub
		
	}
	
}
