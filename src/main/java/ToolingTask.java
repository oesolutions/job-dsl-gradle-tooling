
import java.io.File;
import java.lang.Exception;

import hudson.FilePath;
import hudson.FilePath.FileCallable;
import hudson.remoting.VirtualChannel;

import org.gradle.tooling.*;
import org.gradle.tooling.model.*;


public class ToolingTask {

    public String stringFunc(FilePath path) throws Exception
    {
        String ret = null;
        //try {
            ret = path.act(new ToolingTaskHelper());
        //}
        //catch (Exception e) {
        //    ret = e.toString() + "\n\n" + e.getMessage();
        //}

        return ret;
    }

    private static final class ToolingTaskHelper implements FileCallable<String> {
        private static final long serialVersionUID = 1;

        @Override public String invoke(File f, VirtualChannel channel) {
            String ret = "nothing";
            GradleConnector connector = GradleConnector.newConnector();
            connector.forProjectDirectory(f);
            ProjectConnection connection = connector.connect();
            try {
                // Load the model for the project
                GradleProject project = connection.getModel(GradleProject.class);
                ret = project.getName();
            } finally {
                // Clean up
                connection.close();
            }

            //ret = a.isDirectory() ? "yes" : "no"
            //String[] stuff = f.list();
            //if(stuff != null) {
            //    ret = stuff.join("\n");
            //}

            return ret;
        }
    }
}

