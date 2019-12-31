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
                bat 'java -jar .\spring\target\main.jar'
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