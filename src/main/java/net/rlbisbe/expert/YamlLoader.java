package net.rlbisbe.expert;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

class YamlLoader implements FileLoader<Stage> {

    public Stage loadFromFile() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("options.yaml");
        Map<Object, Object> obj = (Map<Object, Object>) yaml.load(inputStream);

        return getStage(obj);
    }

    private Stage getStage(Map<Object, Object> obj) {
        if (obj == null) {
            return null;
        }

        return Stage.builder()
                .status(obj.get("text").toString())
                .yes(getStage((Map<Object, Object>) obj.get(true)))
                .no(getStage((Map<Object, Object>) obj.get(false)))
                .build();
    }
}
