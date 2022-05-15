import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class calculadora  extends JFrame
{
    JButton add,subtrair,multiplicar,dividir;
    JTextField num1,num2;
    JLabel resultadoado,valor1,valor2;
    
    calcluladora()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        enter1 = new JLabel("1st: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        
        add(enter1,c);
        
        num1 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        add(num1,c);
        
        enter2 = new JLabel("2nd: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=1;
        //c.gridwidth = 1;
        add(enter2,c);
        
        num2 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridx=1;
        add(num2,c);    
        
        // botoes
        add = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=2;
        c.gridwidth = 1;
        add(add,c);
        
        subtrair = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=2;
        add(subtrair,c);
        
        multiplicar = new JButton("*");
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=2;
        add(multiplicar,c);
        
        dividir = new JButton("/");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=3;
        c.gridy=2;
        add(dividir,c);
        
        resultado = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=4;
        add(resultado,c);
        
        event a = new event();
        add.addActionListener(a);
        subtrair.addActionListener(a);
        multiplicar.addActionListener(a);
        dividir.addActionListener(a);
    }
    
    class event implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            double valor1,valor2;
            
            try
            {
                valor1=Double.parseDouble(num1.getText());             
            }
            catch(NumberFormatException e)
            {
                resultado.setText("Dados errados 1� Campo");
                resultado.setForeground(Color.BLUE);
                return;
            }
            try
            {
                valor2 = Double.parseDouble(num2.getText());               
            }
            catch(NumberFormatException e)
            {
                resultado.setText("Dados errados 2� Campo");
                resultado.setForeground(Color.GREEN);
                return;
            }
            String op = a.getActionCommand(); // op for operator
            
            
            if(op.equals("+"))
            {   
                double sum = valor1+valor2;
                resultado.setText(valor1+"+"+valor2+"="+sum);
                resultado.setForeground(Color.RED);
            }
            if(op.equals("-"))
            {
                double diff = valor1-valor2;
                resultado.setText(valor1+"-"+valor2+"="+diff);
                resultado.setForeground(Color.ORANGE);
            }
            if(op.equals("*"))
            {
                double product = valor1*valor2;
                resultado.setText(valor1+"*"+valor2+"="+product);
                resultado.setForeground(Color.GREEN);
            }
            if(op.equals("/"))
            {
                if(valor2==0)
                {
                    resultado.setText("N�o pode dividir por zero");
                    resultado.setForeground(Color.RED);
                }
                else
                {
                    double quo = valor1/valor2;
                    resultado.setText(valor1+"/"+valor2+"="+quo);
                    resultado.setForeground(Color.BLUE);                   
                }
                }
            }
        }
    public static void main(String args[])
    {
        calcluladora ob = new calcluladora();
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setTitle("Calculadora");
        ob.setVisible(true);
        ob.setSize(200,200);
    }
}
