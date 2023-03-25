import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;

public class Main {

    public static void main(String[] s) {
        GLCapabilities caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
        caps.setBackgroundOpaque(true);

        GLWindow glWindow = GLWindow.create(caps);
        glWindow.setTitle("Raw GL2ES2 Demo");
        glWindow.setSize(500, 500);
        glWindow.setUndecorated(false);
        glWindow.setPointerVisible(true);
        glWindow.setVisible(true);
        glWindow.addGLEventListener(new RawGL2ES2demo());
        glWindow.display();
        FPSAnimator animator = new FPSAnimator(120, true);
        animator.add(glWindow);
        animator.start();
    }
}
