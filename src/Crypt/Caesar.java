package Crypt;

import java.util.Scanner;

class Caesar {
 char [] input;
 int key;
 void encrypt()
 {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter the String : ");
  String ip = sc.nextLine();
  input = ip.toCharArray();
  System.out.print("Enter the key : ");
  key = sc.nextInt();
  for(int i=0;i<input.length;i++) {
   if (input[i] == ' ')
    continue;
   else {
    if (input[i] >= 'A' && input[i] <= 'Z') {
     input[i] = (char) (key + input[i]);
     if (input[i] > 'Z') {
      input[i] = (char) (input[i] - 26);
     }
    } else {
     input[i] = (char) (key + input[i]);
     if (input[i] > 'z') {
      input[i] = (char) (input[i] - 26);
     }
    }
   }
  }
  System.out.println("Encrypted String : " + String.valueOf(input) + "\n");
 }
 void decrypt()
 {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter the String : ");
  String ip = sc.nextLine();
  input = ip.toCharArray();
  System.out.print("Enter the key : ");
  key = sc.nextInt();
  for(int i=0;i<input.length;i++)
  {
   if(input[i] == ' ')
    continue;
   else
   {
    if(input[i] >='A' && input[i] <='Z')
    {
     input[i] = (char) (input[i] - key);
     if(input[i] < 'A')
     {
      input[i] = (char) (input[i] + 26);
     }
    }
    else
    {
     input[i] = (char) (input[i] - key);
     if(input[i] < 'a')
     {
      input[i] = (char) (input[i] + 26);
     }
    }
   }
  }
  System.out.println("Decrypted String : " + String.valueOf(input) + "\n");
 }
 void bruteforce()
 {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter the String : ");
  String ip = sc.nextLine();
  input = ip.toCharArray();
  for(key=1;key<27;key++)
  {
   for(int i=0;i<input.length;i++)
   {
    if(input[i] == ' ')
     continue;
    else
    {
     if(input[i] >='A' && input[i] <='Z')
     {
      input[i] = (char) (input[i] - key);
      if(input[i] < 'A')
      {
       input[i] = (char) (input[i] + 26);
      }
     }
     else
     {
      input[i] = (char) (input[i] - key);
      if(input[i] < 'a')
      {
       input[i] = (char) (input[i] + 26);
      }
     }
    }
   }
   System.out.println("Key = " + key + " Decrypted String : " + String.valueOf(input));
   input = ip.toCharArray();
  }
 }

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int c;
  do
  {
   System.out.println("1:Encryption\n2:Decryption\n3:Bruteforce\n4:Exit");
   c = sc.nextInt();
   switch(c)
   {
    case 1 : new Caesar().encrypt(); break;
    case 2 : new Caesar().decrypt(); break;
    case 3 : new Caesar().bruteforce();  break;
    case 4 : break;
   }
  }while(c!=4);
 }
}

