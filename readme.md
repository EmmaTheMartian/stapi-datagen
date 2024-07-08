# Station API Datagen

A library mod for [Station API](https://github.com/ModificationStation/StationAPI) which
allows modders to programmatically generate JSON files.

## Note

Currently, the API does not make hashes of files to check for changes. As of now, all
files are regenerated every time you run data. Along with this, stale files are not
removed. I recommend completely clearing your data generated folder and re-running data
before making a release just to be certain that there are no stale files.

## Usage

1. Include the datagen library. You can do this via Jitpack.

    ```kotlin
    dependencies {
        modImplementation("com.github.emmathemartian:stapi-datagen:version")
    }
    ```

2. Configure source sets to include a new `generated` source set. Make a directory at
`src/generated/`, then add this to your buildscript:

    ```kotlin
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

    ```kotlin
    loom {
        ...
        
        runs {
            register("data") {
                property("datagen.run", "MODID") // replace with your mod's id
                client()
            }
        }
    }
    ```

4. Create an entrypoint for the data generator to find:

   ```java
   public class ModData implements DataEntrypoint {
      public static final String MODID = "example_mod";
      
      @Entrypoint.Namespace
      private static final Namespace NAMESPACE = Null.get();
      
      @Override
      public void run() {
         DataGenContext context = new DataGenContext(NAMESPACE, "../src/generated/resources/assets/" + MODID + "/stationapi/");
         
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

### The window does not appear

This is intentional when running the data generator. Due to when data is made and when
the mod's JAR is made, you can't use any freshly generated files until the next run.

### Old recipes/models/whatever still exist even after removing the code to generate them

Read [note](#note).
