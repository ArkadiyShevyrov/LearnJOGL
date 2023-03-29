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
        Service service = new Service();
        RawGL2ES2demo glEventListener = new RawGL2ES2demo(service);
        glWindow.addGLEventListener(glEventListener);
        glWindow.addKeyListener(new MyKey(glEventListener, service));
        glWindow.display();
        FPSAnimator animator = new FPSAnimator(60, true);
        animator.add(glWindow);
        animator.start();
    }
}
