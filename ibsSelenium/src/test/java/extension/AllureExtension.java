package extension;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import project.managers.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllureExtension implements TestWatcher {
    private List<TestResultStatus> testResultStatus = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        getScreenshot();
        testResultStatus.add(TestResultStatus.FAILED);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
