package school.sptech.adapter.integration.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonResponse {

    private List<AbilityInfo> abilities;

    @JsonProperty("base_experience")
    private int baseExperience;

    @JsonProperty("height")
    private int height;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("order")
    private int order;

    @JsonProperty("sprites")
    private Sprites sprites;

    @JsonProperty("weight")
    private int weight;

    public List<AbilityInfo> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityInfo> abilities) {
        this.abilities = abilities;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static class AbilityInfo {

        @JsonProperty("ability")
        private Ability ability;

        @JsonProperty("is_hidden")
        private boolean isHidden;

        @JsonProperty("slot")
        private int slot;

        public Ability getAbility() {
            return ability;
        }

        public void setAbility(Ability ability) {
            this.ability = ability;
        }

        public boolean isHidden() {
            return isHidden;
        }

        public void setHidden(boolean isHidden) {
            this.isHidden = isHidden;
        }

        public int getSlot() {
            return slot;
        }

        public void setSlot(int slot) {
            this.slot = slot;
        }
    }

    public static class Ability {

        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Sprites {

        @JsonProperty("back_default")
        private String backDefault;

        @JsonProperty("back_female")
        private String backFemale;

        @JsonProperty("back_shiny")
        private String backShiny;

        @JsonProperty("back_shiny_female")
        private String backShinyFemale;

        @JsonProperty("front_default")
        private String frontDefault;

        @JsonProperty("front_female")
        private String frontFemale;

        @JsonProperty("front_shiny")
        private String frontShiny;

        @JsonProperty("front_shiny_female")
        private String frontShinyFemale;

        public String getBackDefault() {
            return backDefault;
        }

        public void setBackDefault(String backDefault) {
            this.backDefault = backDefault;
        }

        public String getBackFemale() {
            return backFemale;
        }

        public void setBackFemale(String backFemale) {
            this.backFemale = backFemale;
        }

        public String getBackShiny() {
            return backShiny;
        }

        public void setBackShiny(String backShiny) {
            this.backShiny = backShiny;
        }

        public String getBackShinyFemale() {
            return backShinyFemale;
        }

        public void setBackShinyFemale(String backShinyFemale) {
            this.backShinyFemale = backShinyFemale;
        }

        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }

        public String getFrontFemale() {
            return frontFemale;
        }

        public void setFrontFemale(String frontFemale) {
            this.frontFemale = frontFemale;
        }

        public String getFrontShiny() {
            return frontShiny;
        }

        public void setFrontShiny(String frontShiny) {
            this.frontShiny = frontShiny;
        }

        public String getFrontShinyFemale() {
            return frontShinyFemale;
        }

        public void setFrontShinyFemale(String frontShinyFemale) {
            this.frontShinyFemale = frontShinyFemale;
        }
    }
}
