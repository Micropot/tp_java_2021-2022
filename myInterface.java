import javax.swing.*;
import javax.swing.text.BoxView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myInterface extends JFrame implements ActionListener {
    private JButton calcul;
    private Double latitude1;
    private Double latitude2;
    private Double longitude1;
    private Double longitude2;
    private Double distance;
    private JTextField zone3;
    private JTextField zone1;
    private JTextField zone2;
    private JButton reset;



//Double latitude1, Double longitude1, Double latitude2, Double longitude2
    public myInterface(Double latitude1, Double longitude1, Double latitude2, Double longitude2){
        super();
        this.latitude1 = latitude1;
        this.latitude2 = latitude2;
        this.longitude1 = longitude1;
        this.longitude2 = longitude2;


        Container fenetre = getContentPane();
        this.setSize(500,500);
        this.setTitle("Calculateur de distance");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelNord = new JPanel();
        JLabel titre = new JLabel("Calculateur de distances");
        Font font = new Font(titre.getFont().getName(),Font.BOLD,titre.getFont().getSize());//permet de garder la meme police et meme taille de text mais de passer le text en gras
        titre.setForeground(Color.red);
        titre.setHorizontalAlignment(JLabel.LEFT);
        titre.setFont(font);
        panelNord.setLayout(new FlowLayout(FlowLayout.LEFT, 0,20));//permet d'organiser les composants ligne par ligne
        panelNord.add(titre);


        JPanel panelCentre = new JPanel();
        JPanel panelCentre1 = new JPanel();
        JPanel panelCentre2 = new JPanel();
        JPanel panelCentre3 = new JPanel();
        JPanel panelCentre4 = new JPanel();


        panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));
        panelCentre.add(Box.createVerticalBox());
        BoxLayout boxLayout = new BoxLayout(panelCentre1, BoxLayout.X_AXIS);
        panelCentre1.setLayout(boxLayout);
        JLabel texte0 = new JLabel("longitude / latitude (décimale)");
        panelCentre1.add(texte0);

        panelCentre2.setLayout(new BoxLayout(panelCentre2, BoxLayout.X_AXIS));

        panelCentre2.add(Box.createRigidArea(new Dimension(0,50)));
        JLabel texte1 = new JLabel("premiere position");
        zone1 = new JTextField(20);
        zone1.setMaximumSize(zone1.getPreferredSize());
        panelCentre2.add(texte1);
        panelCentre2.add(zone1);

        panelCentre3.setLayout(new BoxLayout(panelCentre3, BoxLayout.X_AXIS));
       // panelCentre3.add(Box.createRigidArea(new Dimension(0,100)));
        JLabel texte2 = new JLabel("longitude / latitude (décimale)");
        panelCentre3.add(texte2);

        panelCentre4.setLayout(new BoxLayout(panelCentre4, BoxLayout.X_AXIS));
        //panelCentre4.add(Box.createRigidArea(new Dimension(0,100)));
        JLabel texte3 = new JLabel("seconde position");
        zone2 = new JTextField(20);
        zone2.setMaximumSize(zone2.getPreferredSize());
        panelCentre4.add(texte3);
        panelCentre4.add(zone2);

        JPanel panelSud = new JPanel();
        panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.X_AXIS));
        panelSud.add(Box.createRigidArea(new Dimension(0,100)));
        JLabel texte4 = new JLabel("distance calculée");
        zone3 = new JTextField(20);
        zone3.setMaximumSize(zone3.getPreferredSize());
        panelSud.add(texte4);
        panelSud.add(zone3);

        panelCentre.add(panelCentre1);
        panelCentre.add(panelCentre2);
        panelCentre.add(panelCentre3);
        panelCentre.add(panelCentre4);
        panelCentre.add(panelSud);


        calcul = new JButton("calculer");
        calcul.addActionListener(this);
        /*reset = new JButton("reset");
        reset.addActionListener(this);*/



        fenetre.add(panelNord,BorderLayout.NORTH);
        fenetre.add(panelCentre, BorderLayout.CENTER);
        fenetre.add(calcul,  BorderLayout.SOUTH);
       // fenetre.add(reset,BorderLayout.PAGE_END);
        //Double Distance = Haversine.distance(latitude1,longitude1,latitude2,longitude2);
        //zone3.setText(Double.toString(Distance)+" km");


        this.setVisible(true);


    }

    public void setLatitude1(Double latitude1) {
        this.latitude1 = latitude1;
    }

    public void setLatitude2(Double latitude2) {
        this.latitude2 = latitude2;
    }

    public void setLongitude1(Double longitude1) {
        this.longitude1 = longitude1;
    }

    public void setLongitude2(Double longitude2) {
        this.longitude2 = longitude2;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== calcul){



            String args1 = zone1.getText();

            String[] parts_zone1 = args1.split(",");//permet de recuperer les valeurs entre les virgules
            for(int i = 0; i<parts_zone1.length;i++){
                parts_zone1[i] = parts_zone1[i].trim();//permet de supprimer les espaces
            }
            String args2 = zone2.getText();
            String[] parts_zone2 = args2.split(",");//permet de recuperer les valeurs entre les virgules
            for(int i = 0; i<parts_zone2.length;i++){
                parts_zone2[i] = parts_zone2[i].trim();//permet de supprimer les espaces
            }
            if(parts_zone1.length == 2 && parts_zone2.length==2){
                try {

                    latitude1 = Double.parseDouble(parts_zone1[0]);
                    setLatitude1(latitude1);
                    longitude1 = Double.parseDouble(parts_zone1[1]);
                    setLongitude1(longitude1);
                    latitude2 = Double.parseDouble(parts_zone2[0]);
                    setLatitude2(latitude2);
                    longitude2 = Double.parseDouble(parts_zone2[1]);
                    setLongitude2(longitude2);
                    //System.out.println(longitude1);
                    distance = Haversine.distance(latitude1,longitude1,latitude2,longitude2);
                    zone3.setText(Double.toString(distance)+" km");


                }
                catch (NumberFormatException exception){
                    System.out.println("pas le bon format de nombre");
                }


            }
            else{
                System.out.println("pas le bon nombre d'arguments donnés ");
            }



        }
    }
}
