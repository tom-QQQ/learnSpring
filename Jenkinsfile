pipeline {

    agent any

    stages {

        stage('build') {
            steps {
                bat 'mvn --version'
                powershell 'echo 测试'
                echo '打印成功'
            }
        }

    }
}