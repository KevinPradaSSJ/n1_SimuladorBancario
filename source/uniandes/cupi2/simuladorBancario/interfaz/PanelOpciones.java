/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


/**
 * Panel con las opciones de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la extensión 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante para la extensión 2.
     */
    private final static String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal del simulador.
     */
    private InterfazSimulador principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para hacer la extensión 1.
     */
    private JButton opcion1;

    /**
     * Botón para hacer la extensión 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo panel e inicializa sus elementos. <br>
     * <b>post: </b> Se inicializó el panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( InterfazSimulador pPrincipal )
    {

        // Inicializa los elementos del panel
        principal = pPrincipal;
        opcion1 = new JButton( );
        opcion1.setText( "Opción 1" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );

        opcion2 = new JButton( );
        opcion2.setText( "Opción 2" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );

        // Ubica los elementos en el panel
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 1, 2 ) );
        add( opcion1 );
        add( opcion2 );
    }

    public ArrayList<Integer> panelOpcionUno() {
        JCheckBox cuentaCorriente = new JCheckBox("Cuenta Corriente");
        JCheckBox cuentaCDT = new JCheckBox("Cuenta CDT");
        JCheckBox cuentaAhorros = new JCheckBox("Cuenta de Ahorros");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Selecciona una cuenta:"));
        panel.add(cuentaCorriente);
        panel.add(cuentaAhorros);
        panel.add(cuentaCDT);
        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Seleccionar Opciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            ArrayList<Integer> cuentasSeleccionadas = new ArrayList<>();

            if (cuentaCDT.isSelected())       cuentasSeleccionadas.add(1);
            if (cuentaCorriente.isSelected()) cuentasSeleccionadas.add(2);
            if (cuentaAhorros.isSelected())   cuentasSeleccionadas.add(3);

            if (cuentasSeleccionadas.isEmpty()) { 
            	JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opci�n.", "Opciones Seleccionadas", JOptionPane.INFORMATION_MESSAGE); 
            	return null;	
            }
            return cuentasSeleccionadas;
            
        } else {
            JOptionPane.showMessageDialog(null, "Operaci�n cancelada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    
    
    
    
    public void actionPerformed( ActionEvent pEvento )
    {
        try
        {
            String command = pEvento.getActionCommand( );
            if( command.equals( OPCION_1 ) )
            {
                principal.reqFuncOpcion1( );
            }
            else if( command.equals( OPCION_2 ) )
            {
                principal.reqFuncOpcion2( );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( principal, "Información inválida: intente de nuevo..." );
        }
    

    }

}
