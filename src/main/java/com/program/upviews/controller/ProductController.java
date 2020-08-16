package com.program.upviews.controller;

import com.program.upviews.configuration.flutter.EpisodeItemModel;
import com.program.upviews.configuration.flutter.EpisodeItemResponse;
import com.program.upviews.response.PaypalPaymentResponse;
import com.program.upviews.response.ProductResponse;
import com.program.upviews.service.ProductService;
import static com.program.upviews.util.Api.PRODUCTS_URL;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(PRODUCTS_URL)
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @ApiOperation(value = "Make a purchase", notes = "Saves the project for the selected resume")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success", response = PaypalPaymentResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Not authenticated"),
        @ApiResponse(code = 403, message = "Not authorized to save project"),
        @ApiResponse(code = 500, message = "Internal server error")
      })
  @GetMapping()
  public ProductResponse readProducts() {
    return new ProductResponse(productService.readProducts());
  }

  @GetMapping("/episodes")
  public EpisodeItemResponse readEpisodes() {
    return new EpisodeItemResponse(episodes);
  }

  private static List<EpisodeItemModel> episodes =
      new ArrayList(
          Arrays.asList(
              EpisodeItemModel.builder()
                  .title("Setup, Build and Deploy")
                  .duration(14.07)
                  .imageUrl("https://www.codeproject.com/KB/install/1229196/CI.png")
                  .build(),
              EpisodeItemModel.builder()
                  .title("Adding a Responsive UI")
                  .duration(12.07)
                  .imageUrl("https://miro.medium.com/max/4000/0*t8MtUq5ko9abs0TD.jpg")
                  .build(),
              EpisodeItemModel.builder()
                  .title("Layout Templates")
                  .duration(11.07)
                  .imageUrl("https://www.codeproject.com/KB/install/1229196/CI.png")
                  .build(),
              EpisodeItemModel.builder()
                  .title("State Management and Api integration")
                  .duration(18.07)
                  .imageUrl("https://www.codeproject.com/KB/install/1229196/CI.png")
                  .build()));
}
