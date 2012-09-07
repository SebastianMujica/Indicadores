package SwingBernate;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class InternalFrameMonitor extends InternalFrameAdapter {

  public void internalFrameClosing(InternalFrameEvent e) {
    JInternalFrame w = e.getInternalFrame();
    	System.out.println("Internal Frame Monitor Ventana Cerrada");
		w.dispose();		

  }
}
