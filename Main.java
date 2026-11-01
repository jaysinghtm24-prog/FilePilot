    import java.io.File;
    
    public class Main {
        static int counter = 0;
        public static void main(String[] args) {
            System.out.println("This is FilePilot");
            System.out.println("Your files are organized here, BETTER THAN YOUR COMPUTERS FILESYSTEM");


            File folder = new File("C:\\Users\\Jay\\Downloads");
            scanFolder(folder);
             System.out.println("Total files :" + counter);
        
        }

    
    
    
        public static void scanFolder(File folder){
            
            
            File [] files = folder.listFiles();

            if (files != null){
                for (File file : files ){
                    
                    if (file.isDirectory()){
                        scanFolder(file);
                    }
                    else{
                    String name = file.getName();
                    int dot = name.lastIndexOf(".");
                    if (dot != -1 && dot < name.length() - 1) {
                    String fileType = name.substring(dot + 1);
                    System.out.println(fileType);
                     }
                    
                    float size =file.length()/1024.0f;
                    if(size >= 1024 * 1024 ){
                        size = size/(1024 * 1024) ;
                        System.out.printf(file.getAbsolutePath() + "     %.2f GB%n",size);
                        counter++;
                    }
                    else if (size >= 1024 ){
                        size = size/1024;
                        System.out.printf(file.getAbsolutePath() + "    %.2f MB%n",size);
                        counter++;
                    }

                    else {
                        System.out.printf(file.getAbsolutePath() + "    %.2f KB%n",size);
                        counter++;
                    }
                   
                    
                    }
                    }
                }
            }
        }


