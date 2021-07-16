package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.utils;

import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.Handler;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.postpoints.PostPointsStrategyHandlerData;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers.implementations.PostPointsStrategyHandler;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers.implementations.SocialPointsStrategyHandler;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.socialpoints.SocialPointsStrategyHandlerData;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostCommentByPersonSocialPointsPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostLikedByPersonSocialPointsPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostLikesPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostSharedByPersonSocialPointsPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostSharedCountPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostedByPersonSocialPointsPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.implementations.PostedOnPageFollowersPostPointsStrategy;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations.AdminGroupsStrategy;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations.ConnectionsStrategy;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations.FollowersStrategy;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations.MemberGroupsStrategy;

public class ChainOfResponsibilityUtils {

    public static Handler<SocialPointsStrategyHandlerData> getGenerateSocialPointsHandler() {

        Handler<SocialPointsStrategyHandlerData> adminGroupsStrategyHandler = new SocialPointsStrategyHandler(
                new AdminGroupsStrategy());
        Handler<SocialPointsStrategyHandlerData> connectionsStrategyHandler = new SocialPointsStrategyHandler(
                new ConnectionsStrategy());
        Handler<SocialPointsStrategyHandlerData> followersStrategyHandler = new SocialPointsStrategyHandler(
                new FollowersStrategy());
        Handler<SocialPointsStrategyHandlerData> memberGroupsStrategyHandler = new SocialPointsStrategyHandler(
                new MemberGroupsStrategy());

        adminGroupsStrategyHandler.setNext(connectionsStrategyHandler);
        connectionsStrategyHandler.setNext(followersStrategyHandler);
        followersStrategyHandler.setNext(memberGroupsStrategyHandler);
        return adminGroupsStrategyHandler;
    }

    public static Handler<PostPointsStrategyHandlerData> getGeneratePostPointsHandler() {

        Handler<PostPointsStrategyHandlerData> postCommentByPersonSocialPointsPostPointsStrategyHandler = new PostPointsStrategyHandler(
                new PostCommentByPersonSocialPointsPostPointsStrategy());
        Handler<PostPointsStrategyHandlerData> postedByPersonSocialPointsPostPointsStrategyHandler = new PostPointsStrategyHandler(
                new PostedByPersonSocialPointsPostPointsStrategy());
        Handler<PostPointsStrategyHandlerData> postedOnPageFollowersPostPointsStrategyHandler = new PostPointsStrategyHandler(
                new PostedOnPageFollowersPostPointsStrategy());
        Handler<PostPointsStrategyHandlerData> postLikedByPersonSocialPointsPostPointsStrategyHandler = new PostPointsStrategyHandler(
                new PostLikedByPersonSocialPointsPostPointsStrategy());
        Handler<PostPointsStrategyHandlerData> postLikesPostPointsStrategyHandler = new PostPointsStrategyHandler(
                new PostLikesPostPointsStrategy());
        Handler<PostPointsStrategyHandlerData> postSharedByPersonSocialPointsPostPointsStrategyHandler = new PostPointsStrategyHandler(
                new PostSharedByPersonSocialPointsPostPointsStrategy());
        Handler<PostPointsStrategyHandlerData> postSharedCountPostPointsStrategy = new PostPointsStrategyHandler(
                new PostSharedCountPostPointsStrategy());

        postCommentByPersonSocialPointsPostPointsStrategyHandler.setNext(postedByPersonSocialPointsPostPointsStrategyHandler);
        postedByPersonSocialPointsPostPointsStrategyHandler.setNext(postedOnPageFollowersPostPointsStrategyHandler);
        postedOnPageFollowersPostPointsStrategyHandler.setNext(postLikedByPersonSocialPointsPostPointsStrategyHandler);
        postLikedByPersonSocialPointsPostPointsStrategyHandler.setNext(postLikesPostPointsStrategyHandler);
        postLikesPostPointsStrategyHandler.setNext(postSharedByPersonSocialPointsPostPointsStrategyHandler);
        postSharedByPersonSocialPointsPostPointsStrategyHandler.setNext(postSharedCountPostPointsStrategy);
        return postCommentByPersonSocialPointsPostPointsStrategyHandler;
    }

}
