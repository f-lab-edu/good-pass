package com.goodchalk.goodpass.dailypass.domain.stub;

import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
public class FileStore {
    private final Path masterDirectory;

    public static FileStore createBy(String masterPath) {
        Path masterDirectory = Paths.get(masterPath);
        if (!Files.isDirectory(masterDirectory)) {
            throw new GoodPassSystemException("디렉토리만 FileStore로 생성 가능합니다. masterPath = " + masterPath);
        }
        return new FileStore(masterDirectory);
    }

    public void upload(String targetDirectory, String targetFileName, InputStream sourceInputStream) {
        valid(targetDirectory, targetFileName);

        Path targetDirectoryPath = Paths.get(targetDirectory);
        Path targetFilePath = Paths.get(targetFileName);
        Path targetPath = masterDirectory.resolve(targetDirectoryPath).resolve(targetFilePath);

        try (OutputStream targetOutputStream = toBufferedOutputStream(targetPath.toFile())) {
            byte[] buffer = new byte[8192];
            while (true) {
                int len = sourceInputStream.read(buffer);
                if (len == -1) {
                    targetOutputStream.flush();
                    return;
                }
                targetOutputStream.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void valid(String directoryPath, String filename) {
        Path pathFromMasterDirectory = getPathFromMasterDirectory(directoryPath);
        if (!Files.isDirectory(pathFromMasterDirectory)) {
            throw new GoodPassSystemException("타당하지 않은 path 입니다. path=" + pathFromMasterDirectory);
        }

        Path resolve = pathFromMasterDirectory.resolve(filename);
        if (Files.isDirectory(resolve)) {
            throw new GoodPassSystemException("타당하지 않은 path 입니다. path=" + resolve);
        }
    }

    private Path getPathFromMasterDirectory(String path) {
        return masterDirectory.resolve(Paths.get(path));
    }
    private OutputStream toBufferedOutputStream(File file) {
        try {
            OutputStream fos = new FileOutputStream(file);
            return new BufferedOutputStream(fos, 8192);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
