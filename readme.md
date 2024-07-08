# Station API Datagen

A library mod for [Station API](https://github.com/ModificationStation/StationAPI) which
allows modders to programmatically generate JSON files.

## Note

Currently, the API does not make hashes of files to check for changes. As of now, all
files are regenerated every time you run data. Along with this, stale files are not
removed. I recommend completely clearing your data generated folder and re-running data
before making a release just to be certain that there are no stale files.

## Usage

> The buildscript codeblocks are Groovy, however it should be very similar (if not then
> exactly the same) in Kotlin DSL.

1. Include the datagen library. You can do this via Jitpack:

    ```groovy
    dependencies {
        modImplementation("com.github.emmathemartian:stapi-datagen:version")
    }
    ```

2. Configure source sets to include a new `generated` source set. Make a directory at
`src/generated/`, then add this to your buildscript:

    ```groovy
    sourceSets {
        main {
            java {
                srcDir("src/main/java")
            }
            resources {
                srcDir("src/test/resources")
                srcDir("src/generated/resources")
            }
        }
    }
    ```

3. Create a new run configuration to run the data generator:

    ```groovy
    loom {
        ...
        
        runs {
            register("data") {
                property("datagen.run", "MODID") // replace with your mod's id
                property("datagen.path", project.projectDir.toPath().resolve("src/generated/resources/").toAbsolutePath().toString())
                client()
            }
        }
    }
    ```

4. Create an entrypoint for the data generator to find:

   ```java
   public class ModData implements DataEntrypoint {
      @Entrypoint.Namespace
      private static final Namespace NAMESPACE = Null.get();
      
      @Override
      public void run() {
         DataGenContext context = new DataGenContext(NAMESPACE);
         
         context.run(new CraftingRecipeProvider(context) {
            @Override
            public void run(DataGenContext context) {
               shapeless()
                     .ingredient(Ingredient.of(Block.DIRT.asItem()))
                     .ingredient(Ingredient.of(Item.WATER_BUCKET))
                     .result(new ItemStack(Block.CLAY.asItem()))
                     .save("dirt_to_clay", this, context);
            }
         });
      }
   }
   ```
      
   ```json5
   // fabric.mod.json
   {
      "entrypoints": {
         "data": [
            "yourpackage.ModData"
         ]
      }
   }
   ```

5. Reload Gradle and test using `gradlew runData`. You should see the file at
`src/generated/resources/assets/example_mod/stationapi/recipes/crafting/dirt_to_clay.json`.

> See `src/test/java/emmathemartian/datagen/test/` for a more comprehensive example.

## Troubleshooting

### The window does not appear or it closes after loading

This is intentional when running the data generator. Due to when data is made and when
the mod's JAR is made, you can't use any freshly generated files until the next run.

### Old recipes/models/whatever still exist even after removing the code to generate them

Read [note](#note).

### "Entry ... is a duplicate but no duplicate handling strategy has been set."

Either you have a literal duplicate file across two source sets, or you are experiencing
[this](https://github.com/gradle/gradle/issues/17236) bug. If you do not have any
duplicate *files*, but you have duplicate *folders*, it will be the latter.

> Example: `src/main/resouces/assets/` and `src/generated/resources/assets/`. The `assets`
> folder is flagged as a duplicate for some reason. Thanks Gradle.

To fix the latter, just put this line in `processResources` (or whatever other task is
failing):

```groovy
duplicatesStrategy = DuplicatesStrategy.EXCLUDE
```

If you prefer not to hunt down individual tasks to define `duplicatesStrategy` in, then
you can add this code to your buildscript, which should configure the duplicates strategy
for most tasks where it is important:

```groovy
tasks.withType(Jar).configureEach {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType(Copy).configureEach {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
```
