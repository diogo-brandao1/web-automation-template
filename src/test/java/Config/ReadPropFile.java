package Config;

import java.io.*;
import java.util.Properties;

public class ReadPropFile {

    /**
     * Create a Properties variable and then read "config.properties" file and add to the Properties variable.
     * Then call the function "setEnvironment" sending the "Properties", propertyName="env" and "environmentDefault" parameters.
     * Then will get the environment from the properties
     * Then load the OS configuration file and merge with the configurations Properties,
     * Then load the correct ENVIRONMENT configuration file using the "env" variable and merge with the configurations Properties,
     * @param environmentDefault default environment will be used if the file "config.properties" does not have the variable "env"
     * @return Properties
     * @throws IOException
     */
    public static Properties readPropertiesFiles(String environmentDefault) throws IOException {
        Properties properties = new Properties();
        String env;

        String configPropertiesFilePath = "config.properties";
        Properties configProperties = loadPropertiesFile(configPropertiesFilePath);
        properties.putAll(configProperties);

        properties = setEnvironment(properties, "env", environmentDefault);
        env = properties.getProperty("env");

        String OSConfiguration = getOSProp();
        String osPropertiesFilePath = System.getProperty("user.dir") + "/src/test/resources/os/" + OSConfiguration;
        InputStream osProperties = new FileInputStream(osPropertiesFilePath);
        properties.load(osProperties);
        osProperties.close();

        String envPropertiesFilePath = System.getProperty("user.dir") + "/src/test/resources/env/" + "config." + env + ".properties";
        InputStream envPropertiesFile = new FileInputStream(envPropertiesFilePath);
        properties.load(envPropertiesFile);
        envPropertiesFile.close();

        //Print the properties on the screen
        //printProperties(properties);
        return properties;
    }

    /**
     * Check if the command line has present the received variable "propertyName", if yes will read and update on properties.
     * If not, will search on properties file for the received variable "propertyName", if exist will read and update on properties.
     * If not, will update the property with the received propertyValueDefault
     * @param properties - properties list
     * @param propertyName - name of the property to be search
     * @param propertyValueDefault - default property value
     * @return properties
     */
    public static Properties setEnvironment(Properties properties, String propertyName, String propertyValueDefault) {
        String env;
        //command line
        env = System.getProperty(propertyName);
        if( env != null && env.length() > 0 ){
            properties.setProperty(propertyName, env);
        }else{
            //Properties
            env = properties.getProperty(propertyName);
            if( env != null && env.length() > 0 ){
                properties.setProperty(propertyName, env);
            }else{
                properties.setProperty(propertyName, propertyValueDefault);
            }
        }
        return properties;
    }

    /**
     * call the function "getOS" from "OSConfiguration" class to get the operative system from THIS machine
     * and then, will return the configurations properties file name reference from THIS operating system
     * @return operative system configuration properties file name
     */
    public static String getOSProp() {
        switch (OSConfiguration.getOS()) {
            case WINDOWS:
                return "config.windows.properties";
            case LINUX:
                return "config.linux.properties";
            case MAC:
                return "config.mac.properties";
            default:
               return "config.local.properties";
        }
    }

    /**
     * will read a file on the "filePath" and load the properties
     * if the file was not able to be loaded, will throw an error
     * @param filePath
     * @return Properties
     */
    public static Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = ReadPropFile.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }

    /**
     * get a Properties and parse to String, then will print it
     * @param prop
     */
    public static void printProperties(Properties prop) {
        StringWriter writer = new StringWriter();
        prop.list(new PrintWriter(writer));
        System.out.println(writer.getBuffer().toString());
    }
}
