import java.io.*; 
class StreamTokenDemo { 
public static int words=0; 
public static int lines=0; 
public static int chars=0; 
public static void wc(Reader r) throws IOException { 
StreamTokenizer tok = new StreamTokenizer(r); 
tok.resetSyntax(); 
tok.wordChars(33, 255); 
tok.whitespaceChars(0, ' '); 
tok.eolIsSignificant(true); 
while (tok.nextToken() != tok.TT_EOF) { 
switch (tok.ttype) { 
case 10: 
lines++; 
chars++; 
break; 
case -3: 
words++; 
default: // FALLSTHROUGH 
chars += tok.sval.length(); 
break; 
} 
} 
} 
public static void main(String args[]) { 
if (args.length == 0) { // We're working with stdin 
try { 
wc(new InputStreamReader(System.in)); 
System.out.println(lines + " " + words + " " + chars); 
} catch (IOException e) {}; 
} else { // We're working with a list of files 
int twords = 0, tchars = 0, tlines = 0; 
for (int i=0; i<args.length; i++) { 
try { 
words = chars = lines = 0; 
wc(new FileReader(args[i])); 
twords += words; 
tchars += chars; 
tlines += lines; 
System.out.println(args[i] + ": " + 
lines + " " + words + " " + chars); 
} catch (IOException e) { 
System.out.println(args[i] + ": error."); 
} 
} 
System.out.println("total: " + 
tlines + " " + twords + " " + tchars); 
} 
} 
}