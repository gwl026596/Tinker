# Tinker
微信热更新集成研究和遇到问题
集成过程中一直修改资源文件，打patch包不成功
错误：com.tencent.tinker.build.util.TinkerPatchException: resource must contain resources.arsc pattern

主要原因是配置gradle项错误 "resources.arcs", "AndoridManifest.xml"

1.错误写法
    res {

            pattern = ["res/*", "assets/*", "resources.arcs", "AndoridManifest.xml"]
            //指定tinker可以修改的资源路径

            ignoreChange = ["assets/sample_meta.txt"] //指定不受影响的资源路径

            largeModSize = 100 //资源修改大小默认值
        }
        
 2.正确写法
 
 
     res {

            pattern = ["res/*", "assets/*", "resources.arsc", "AndroidManifest.xml"]
            //指定tinker可以修改的资源路径

            ignoreChange = ["assets/sample_meta.txt"] //指定不受影响的资源路径

            largeModSize = 100 //资源修改大小默认值
        }
