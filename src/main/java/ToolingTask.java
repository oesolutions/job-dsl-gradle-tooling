

//@GrabResolver(name='gradle', root='http://repo.gradle.org/gradle/libs-releases-local')
//@Grab(group='org.gradle', module='gradle-tooling-api', version='1.11')

import hudson.FilePath;
import hudson.FilePath.FileCallable;
import hudson.remoting.VirtualChannel;
import java.io.File;

//import org.gradle.tooling.*;
//import org.gradle.tooling.model.*

public class TestWrapper {

    public String stringFunc(FilePath path)
    {
        return path.act(new ToolingTask())
    }

    private static final class ToolingTask implements FileCallable<String> {
        private static final long serialVersionUID = 1;

        @Override public String invoke(File f, VirtualChannel channel) {
            String ret = "nothing";
            //GradleConnector connector = GradleConnector.newConnector()
            //connector.forProjectDirectory(f)
            //ProjectConnection connection = connector.connect()
            //try {
                // Load the model for the project
            //    GradleProject project = connection.getModel(GradleProject.class)
            //    ret = project.getName()
            //} finally {
                // Clean up
            //    connection.close();
            //}

            //ret = a.isDirectory() ? "yes" : "no"
            //String[] stuff = f.list();
            //if(stuff != null) {
            //    ret = stuff.join("\n");
            //}

            return ret;
        }
    }
}

