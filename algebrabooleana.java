/*
    Autor: Matheus Silva Lara
    GitHub: github.com/MattheusLara
    LinkedIn: www.linkedin.com/in/matheus-lara-0316b51b4/
*/

public class algebrabooleana{


   public static String isNot(String frase, int tamanho, int aux){//Metodo para realizar a operaçao not.       
      char resp = '2';
      String fraseResp = "";    
      int inicio = aux -2;
      int cont = 0;

      do{ // Varre o parentese do not proucurando 0 ou 1 ate achar o seu fim, e  armazena o resultado na variavel resp.
         aux = aux + 1; 

         if(frase.charAt(aux) == '1'){
               resp = '0';
         }
         else if(frase.charAt(aux) == '0'){
               resp = '1';
         }
          
      }while(frase.charAt(aux) != ')');
      
      
      for(cont = 0;cont < inicio;cont++){  // Copia a string ate a operaçao not.
         fraseResp += frase.charAt(cont);
      }
      
      for(cont = inicio;cont < aux;cont++){ // Substitui a operaçao do not por '.'.
         fraseResp += '.';
      }

      fraseResp += resp; // Armazena o resultado da operaçao apos ela ser substituida por '.'.

      for(cont = aux +1;cont < tamanho;cont++){ // Copia o restate da string apos o operaçao do not.
         fraseResp += frase.charAt(cont);
      }  

      return(fraseResp);
   
   }
   
   public static String isAnd(String frase, int tamanho,int aux){ 
      char resp = '1';
      String fraseResp = "";    
      int inicio = aux -2;
      int cont = 0;

      do{ // Varre o parentese do and proucurando 0 ate achar o seu fim, e  armazena o resultado na variavel resp.
         aux = aux + 1; 

         if(frase.charAt(aux) == '0'){
               resp = '0';
         }
          
      }while(frase.charAt(aux) != ')');
      
      for(cont = 0;cont < inicio;cont++){ // Copia a string ate a operaçao and.       
         fraseResp += frase.charAt(cont);
      }
      
      for(cont = inicio;cont < aux;cont++){ // Substitui a operaçao do and por '.'.
         fraseResp += '.';
      }

      fraseResp += resp; // Armazena o resultado da operaçao apos ela ser substituida por '.'.

      for(cont = aux +1;cont < tamanho;cont++){ // Copia o restate da string apos o operaçao do not.
         fraseResp += frase.charAt(cont);
      }      

      return(fraseResp);
   }
   
   
   public static String isOr(String frase, int tamanho,int aux){ 
      char resp = '0';
      String fraseResp = "";    
      int inicio = aux -1;
      int cont = 0;

      do{ // Varre o parentese do and proucurando 1 ate achar o seu fim, e  armazena o resultado na variavel resp.
         aux = aux + 1; 

         if(frase.charAt(aux) == '1'){
               resp = '1';
         }
          
      }while(frase.charAt(aux) != ')');
      
      for(cont = 0;cont < inicio;cont++){ // Copia a string ate a operaçao or.            
         fraseResp += frase.charAt(cont);
      }
      
      for(cont = inicio;cont < aux;cont++){// Substitui a operaçao do or por '.'.
         fraseResp += '.';
      }

      fraseResp += resp; // Armazena o resultado da operaçao apos ela ser substituida por '.'.

      for(cont = aux +1;cont < tamanho;cont++){// Copia o restate da string apos o operaçao do not.
         fraseResp += frase.charAt(cont);
      }     

      return(fraseResp);
   
   }
   
   public static int algebraBooleana(String frase, int tamanho){      
      int quant = 0;
      int cont = 0;
      int A; 
      int B;
      int C = 0;
      int result = -1;
      int aux;
      int tam = tamanho;
      String fraseAux = "";
      
      quant = (int)(frase.charAt(0));
      
      A = (int)frase.charAt(2) - 48; // -48 usado para fazer a conv da ascii para int.
      B = (int)frase.charAt(4) - 48;  
   
      if(quant == 51){// Valor de 3 na tabela Ascii
         C = (int)frase.charAt(6) - 48;
      }

      for(cont = 0;cont < tamanho;cont++){ //Substituio o a string substituindo as variaveis A B e C por seus respectivos falores.
         if(frase.charAt(cont) == 'A'){
            fraseAux += A;
         }
         else if(frase.charAt(cont) == 'B'){
            fraseAux += B;
         }
         else if(frase.charAt(cont) == 'C'){
            fraseAux += C;
         }
         else{
            fraseAux += frase.charAt(cont);
         }
      }
      
      do{   //Varre a String de traz para frente ate achar o parentese de abertura da operaçao.
         tamanho = tamanho - 1;
         if(fraseAux.charAt(tamanho) == '('){
            aux = tamanho - 1; // Apos achar o aux e setado ultima letra da operaçao.
            if(fraseAux.charAt(aux) == 't'){ // Verifica se a operçao e not.
               fraseAux = isNot(fraseAux,tam,aux);
            }
            else if(fraseAux.charAt(aux) == 'd'){ // Verifica se a operçao e and.
               fraseAux = isAnd(fraseAux,tam,aux);
            }
            else{
               fraseAux = isOr(fraseAux,tam,aux); // Caso nao seja nem uma das outras operaçoes ela obrigatoriamente eh or.
            }  
         } 
         
      }while(tamanho > 0);
      
      tamanho = fraseAux.length();

      result = fraseAux.charAt(tamanho-1);
      
      if(result == 48){ // Verifica se o resultado e 0.
         result = 0; 
      }
      else{ // Se o resultado nao e 0 obrigatoriamente e 1.
         result = 1;
      }
            
      return (result); 
   }
                     
   public static boolean verificaFim( int tamanho){ // Verifica se e o fim do programa.
      return (tamanho == 1);
   }

   public static void main(String[]args){
    
      String frase;
      boolean saida = false;
      int tamanho = 0;
      int maiusculas;
      
      int cont = 0;

      do{      
         
         frase = MyIO.readLine();
         
         tamanho = frase.length();

         if(frase.charAt(tamanho-1) == ' '){
            tamanho = tamanho -1;
         }
         
         if(verificaFim(tamanho)){ // Verifica se e o fim do programa.
            saida = true; // Torna a saida igual a 1 para finalizar o la�o.
         }
         else{
            MyIO.println(algebraBooleana(frase,tamanho));
         }

      }while(saida != true);
   
   }

}