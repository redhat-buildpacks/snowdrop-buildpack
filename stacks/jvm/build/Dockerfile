ARG base_image
FROM ${base_image}

ARG stack_id

# Set required CNB information
ENV CNB_STACK_ID=${stack_id}
# ENV CNB_USER_ID=${cnb_uid}
ENV CNB_USER_ID=185
# ENV CNB_GROUP_ID=${cnb_gid}
ENV CNB_GROUP_ID=185

LABEL io.buildpacks.stack.id=${stack_id}

USER 185
