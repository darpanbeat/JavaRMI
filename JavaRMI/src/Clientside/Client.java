package Clientside; 

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import RMIinterface.RMIport;
import RMIinterface.compute;

import javax.swing.JTextArea;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel item1;
	private JLabel item2;
	private JTextField itemtext;
	private JComboBox dropdown;
	private JTextArea itemarea;
	private JButton submit;
	
	
	private static String findlist[] = {"Find Location", "Find the list of songs"};

	public Client(){
		super("Client GUI");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("RMI-based Access to Hadoop/MapReduce-Processed Music Datasets");
		add(item1);
		item2 = new JLabel("Enter Artist Name");
		add(item2);
		itemtext = new JTextField(20);
		add(itemtext);
		
		dropdown = new JComboBox();
		dropdown.addItem("Get Location");
		dropdown.addItem("List Of Songs");
		add(dropdown);
		
		itemarea = new JTextArea(20,40);
		add(new JScrollPane(itemarea));
		
		submit = new JButton("Submit");
		add(submit);
		submit.addActionListener(this);
				
	
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object button = e.getSource();
		
		if(button == submit)
		{
			itemarea.setText(null);
			if(dropdown.getSelectedItem().equals("Get Location"))
			{
				String sendstring = itemtext.getText()+"location1";
				calltointerface(sendstring);
			}
			else
			{
				String sendstring = itemtext.getText()+"songs";
				calltointerface(sendstring);
			}
		}
	}
	
	public void calltointerface(String item)
	{
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("localhost",RMIport.RMI_PORT);
			compute obj = (compute) registry.lookup(RMIport.RMI_ID);
			String result = obj.executeTask(item);
			
			if(item.contains("songs"))
			{
				String words[] = result.split("<I>");
				for(int i=0;i<words.length;i++)
				{
					itemarea.append(words[i]+"\n");
				}
			}
			else
			{
				itemarea.append(result+"");
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

