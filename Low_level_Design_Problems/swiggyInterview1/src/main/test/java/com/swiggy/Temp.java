

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileStorageTest {

    @Autowired
    private FileStorageService fileStorageService;

    @org.junit.Test
    public void test1 () {
//        fileStorageService.createFolderInBucketIfNotPresent("1234");
    }

    @org.junit.Test
    public void fileUploadPreassignedUrlTest(URL url) throws IOException {
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("This text uploaded as object.");
        out.close();
        int responseCode = connection.getResponseCode();
        System.out.println("Service returned response code " + responseCode);
    }
}