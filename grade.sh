CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
set -e
if [[ -f "student-submission/ListExamples.java" ]]
then
    echo "File found"
else
    echo "Wrong file submitted"
    exit
fi

cp -r student-submission/ListExamples.java grading-area
cp -r TestListExamples.java grading-area
cp -r lib grading-area
set +e
cd ./grading-area
javac -cp $CPATH  *.java
if [ $? -ne 0 ]
then
    echo "compilation error"
    exit 1
fi
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples

