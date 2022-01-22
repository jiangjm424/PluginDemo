package cn.jm.happy.helloPlugin

import com.android.build.api.transform.*
import org.gradle.api.Project

/**
 * transform api
 */
class StaticsTransform extends Transform {

    Project project
    static File fileContainsInitClass;

    StaticsTransform(Project project) {
        this.project = project
    }

    /**
     * name of this transform
     * @return
     */
    @Override
    String getName() {
        return "register_transform"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    /**
     * The plugin will scan all classes in the project
     * @return
     */
    @Override
    Set<QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        println "custom plugin transform start--------> $System.currentTimeMillis()"
        transformInvocation.inputs.forEach {
            it.directoryInputs.forEach {
                println "dir: $it"
            }
            it.jarInputs.forEach {
                println "jar: $it"
            }
        }
        println "custom plugin transform end--------> $System.currentTimeMillis()"
    }

}
