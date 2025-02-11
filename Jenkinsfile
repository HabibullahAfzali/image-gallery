pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/HabibullahAfzali/image-gallery.git'
            }
        }

        stage('Install Docker Compose') {
            steps {
                sh '''
                if ! [ -x "$(command -v docker-compose)" ]; then
                    curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
                    chmod +x /usr/local/bin/docker-compose
                fi
                '''
            }
        }

        stage('Build Backend (Spring Boot with Maven)') {
            steps {
                sh 'mvn clean install'  // Build the Spring Boot backend using Maven
            }
        }

        stage('Build Frontend (React)') {
            steps {
                sh 'npm install && npm run build'  // Build the frontend using npm
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'docker-hub-secret', variable: 'DOCKER_TOKEN')]) {
                    sh 'docker login -u habibafzali -p $DOCKER_TOKEN'  // Login to Docker Hub using the secret token
                }
            }
        }

        stage('Run Docker (MySQL)') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d'  // Start MySQL container using Docker Compose
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'  // Run tests using Maven
            }
        }
    }

    post {
        always {
            echo 'Cleaning up Docker...'
            sh 'docker-compose -f docker-compose.yml down'  // Stop the Docker containers after pipeline finishes
        }
    }
}
