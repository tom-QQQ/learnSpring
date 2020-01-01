pipeline {

    agent any

    stages {

        stage('common mvn') {
            steps {
                bat 'mvn clean install -Dmaven.test.skip=true'
                echo 'build 成功'
            }
        }

        stage('start') {
            steps {
                // 进入指定目录, 注意分隔符号
                dir ('spring/target/') {
                    // bat 'ls'
                    bat 'java -jar main.java'
                }
                // bat 'java -jar spring\target\main.jar'
            }

            post {
                success {
                    echo '启动成功'
                }

                failure {
                    echo '启动失败'
                }
            }
        }
    }
}