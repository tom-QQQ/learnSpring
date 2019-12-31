pipeline {

    agent any

    stages {

        stage('build') {
            steps {
                bat 'mvn --version'
                powershell 'chcp'
                echo '打印成功'
            }
        }

    }
}