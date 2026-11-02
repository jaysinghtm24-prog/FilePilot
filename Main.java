    import java.io.File;
    
    public class Main {
        static int counter = 0;
        public static void main(String[] args) {
            System.out.println("This is FilePilot");
            System.out.println("Your files are organized here, BETTER THAN YOUR COMPUTERS FILESYSTEM");


           File folder = new File("C:\\Users\\Jay\\OneDrive\\Desktop\\FilePilotTest");
            scanFolder(folder);
             // CREATING THE FOLDER WHICH SHALL CONTAIN THE ORGANISED SUBFOLDERS AND FILES
                    File newFolder = new File("C:\\Users\\Jay\\OneDrive\\Desktop\\FilePilotTest\\FilePilot Organized");
                    newFolder.mkdir();

                    //CREATING SUBFOLDERS 
                    File images = new File (newFolder,"Images");
                    images.mkdir();

                    File pdf = new File(newFolder,"PDF");
                    pdf.mkdir();

                    File documents = new File(newFolder, "Documents");
                    documents.mkdir();

                    File videos = new File(newFolder, "Videos");
                    videos.mkdir();

                    File code = new File(newFolder, "Code");
                    code.mkdir();
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

                    //THIS IS FOR IDENTIFYING THE TYPE OF FILE
                    // IDENTIFY FILE TYPE
String name = file.getName();
int dot = name.lastIndexOf(".");

if (dot != -1 && dot < name.length() - 1) {

    String fileType = name.substring(dot + 1).toLowerCase();

    switch (fileType) {

        case "jpg":
        case "jpeg":
        case "png":
        case "gif":
            System.out.println("Category: Images");
            break;

        case "pdf":
            System.out.println("Category: PDF");
            break;

        case "doc":
        case "docx":
        case "txt":
            System.out.println("Category: Documents");
            break;

        case "mp4":
        case "mkv":
        case "avi":
            System.out.println("Category: Videos");
            break;

        case "java":
        case "py":
        case "cpp":
        case "c":
            System.out.println("Category: Code");
            break;

        default:
            System.out.println("Category: Other");
            break;
    }
}
                     }
                    //THIS IS FOR GETING SIZE OF THE FILE
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
        


