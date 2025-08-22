pipeline {
  agent any

  environment {
    MVN = tool 'Maven 3.8.7'   // Jenkins Maven installation
  }

  parameters {
    choice(name: 'RUN_MODE', choices: ['tags'], description: 'Choose how to select tests')
    string(name: 'TAGS', defaultValue: '@loginTest', description: 'Comma-separated tags for parallel runs (only if RUN_MODE=tags)')
    string(name: 'SUITES', defaultValue: 'smoke.xml,regression.xml', description: 'Comma-separated suite files for parallel runs (only if RUN_MODE=suite)')
    string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser to use')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        sh "${MVN}/bin/mvn clean compile -DskipTests"
      }
    }

    stage('Run Tests in Parallel') {
      steps {
        script {
          def tasks = [:]

          if (params.RUN_MODE == 'tags') {
            def tagList = params.TAGS.split(",")
            tagList.each { tag ->
              def tagName = tag.trim()
              tasks["Run ${tagName}"] = {
                sh "${MVN}/bin/mvn test -Dcucumber.filter.tags=\"${tagName}\" -Dbrowser=${params.BROWSER}"
              }
            }
          } else if (params.RUN_MODE == 'suite') {
            def suiteList = params.SUITES.split(",")
            suiteList.each { suite ->
              def suiteFile = suite.trim()
              tasks["Run ${suiteFile}"] = {
                sh "${MVN}/bin/mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suites/${suiteFile} -Dbrowser=${params.BROWSER}"
              }
            }
          }

          parallel tasks
        }
      }
      post {
        always {
          archiveArtifacts artifacts: 'target/**/*.html, target/**/*.json, target/screenshots/**/*', allowEmptyArchive: true
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Publish Reports') {
      steps {
        publishHTML(target: [
          allowMissing: true,
          keepAll: true,
          alwaysLinkToLastBuild: true,
          reportDir: 'target',
          reportFiles: 'cucumber-html-report/index.html',
          reportName: 'Cucumber Report'
        ])
      }
    }
  }

  post {
    always {
      echo "Build finished: ${currentBuild.currentResult}"
    }
  }
}