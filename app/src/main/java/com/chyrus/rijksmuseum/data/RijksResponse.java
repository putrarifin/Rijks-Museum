package com.chyrus.rijksmuseum.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RijksResponse {

    @SerializedName("artObjects")
    private List<ArtObjects> artObjects;
    @SerializedName("count")
    private int count;
    @SerializedName("elapsedMilliseconds")
    private int elapsedMilliseconds;

    public List<ArtObjects> getArtObjects() {
        return artObjects;
    }

    public int getCount() {
        return count;
    }

    public int getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public static class ArtObjects {
        @SerializedName("productionPlaces")
        private List<String> productionPlaces;
        @SerializedName("headerImage")
        private HeaderImage headerImage;
        @SerializedName("webImage")
        private WebImage webImage;
        @SerializedName("permitDownload")
        private boolean permitDownload;
        @SerializedName("showImage")
        private boolean showImage;
        @SerializedName("longTitle")
        private String longTitle;
        @SerializedName("principalOrFirstMaker")
        private String principalOrFirstMaker;
        @SerializedName("hasImage")
        private boolean hasImage;
        @SerializedName("title")
        private String title;
        @SerializedName("objectNumber")
        private String objectNumber;
        @SerializedName("id")
        private String id;
        @SerializedName("links")
        private Links links;

        public List<String> getProductionPlaces() {
            return productionPlaces;
        }

        public HeaderImage getHeaderImage() {
            return headerImage;
        }

        public WebImage getWebImage() {
            return webImage;
        }

        public boolean getPermitDownload() {
            return permitDownload;
        }

        public boolean getShowImage() {
            return showImage;
        }

        public String getLongTitle() {
            return longTitle;
        }

        public String getPrincipalOrFirstMaker() {
            return principalOrFirstMaker;
        }

        public boolean getHasImage() {
            return hasImage;
        }

        public String getTitle() {
            return title;
        }

        public String getObjectNumber() {
            return objectNumber;
        }

        public String getId() {
            return id;
        }

        public Links getLinks() {
            return links;
        }
    }

    public static class HeaderImage {
        @SerializedName("url")
        private String url;
        @SerializedName("height")
        private int height;
        @SerializedName("width")
        private int width;
        @SerializedName("offsetPercentageY")
        private int offsetPercentageY;
        @SerializedName("offsetPercentageX")
        private int offsetPercentageX;
        @SerializedName("guid")
        private String guid;

        public String getUrl() {
            return url;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getOffsetPercentageY() {
            return offsetPercentageY;
        }

        public int getOffsetPercentageX() {
            return offsetPercentageX;
        }

        public String getGuid() {
            return guid;
        }
    }

    public static class WebImage {
        @SerializedName("url")
        private String url;
        @SerializedName("height")
        private int height;
        @SerializedName("width")
        private int width;
        @SerializedName("offsetPercentageY")
        private int offsetPercentageY;
        @SerializedName("offsetPercentageX")
        private int offsetPercentageX;
        @SerializedName("guid")
        private String guid;

        public String getUrl() {
            return url;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getOffsetPercentageY() {
            return offsetPercentageY;
        }

        public int getOffsetPercentageX() {
            return offsetPercentageX;
        }

        public String getGuid() {
            return guid;
        }
    }

    public static class Links {
        @SerializedName("web")
        private String web;
        @SerializedName("self")
        private String self;

        public String getWeb() {
            return web;
        }

        public String getSelf() {
            return self;
        }
    }

}
